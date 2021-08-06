package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OCRService {
    private Map<String, String[]> categoryToRetailerMap = new HashMap<String, String[]>();
    public OCRService() {
        categoryToRetailerMap.put("Grocery", new String[]{"Walmart", "Bakers", "Hy-vee"});
        categoryToRetailerMap.put("Rent", new String[]{});
        categoryToRetailerMap.put("Mortgage", new String[]{});
        categoryToRetailerMap.put("Entertainment", new String[]{"Target", "AMC", "Amazing Pizza Machine"});
        categoryToRetailerMap.put("Transportation", new String[]{"Metro", "Kwik Trip", "BP"});
        categoryToRetailerMap.put("Laundry", new String[]{"Wash World"});
        categoryToRetailerMap.put("Utilities", new String[]{"OPPD", "MUD"});
    }

    /**
     * runs OCR on the image at the specified file path
     * @param filePath,
     * @param budgetName
     * @return Expense obejct with values from receipt scan
     */
    public Expense runOCR(String filePath, String budgetName) {
        String textFromImage = extractTextFromImage(filePath);
//        System.out.println(textFromImage);
        Expense expense = parseExpense(textFromImage, budgetName);
        System.out.println("Expense Cost: "  + expense.getCost());
        System.out.println("Expense Category: " + expense.getCategory());
        return expense;
    }

    /**
     * takes extracted text from receipt image and calls helper methods
     * on it to set Expense fields
     * @param txt
     * @param budgetName
     * @return Expense
     */
    private Expense parseExpense(String txt, String budgetName) {
        Expense expense = new Expense();
        expense.setCategory(getCategoryFromReceipt(txt));
        expense.setCost(getCostFromReceipt(txt));
        expense.setBudgetName("August 2021 Budget");
        return expense;
    }

    /**
     * uses regex to try to find any of the recognized retailers
     * in the receipt text, then uses the hashmap to assign a
     * category based on the found retailer
     * @param txt
     * @return category
     */
    private String getCategoryFromReceipt(String txt) {
        String category = "";
        for(Map.Entry<String, String[]> e: this.categoryToRetailerMap.entrySet()) {
            String[] arr = e.getValue();
            for(String a: arr) {
                Pattern pattern = Pattern.compile(a, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(txt);
                if(matcher.find()) {
                    category = e.getKey();
                    break;
                }
            }
        }
        return category;
    }

    /**
     * uses regex to find total in the receipt text,
     * then extracts the amount next to it
     * @param txt
     * @return amount
     */
    private BigDecimal getCostFromReceipt(String txt) {
        String amountValue = "0";
        Pattern p = Pattern.compile("(Total|total|TOTAL)\\s*(\\w+)");
        Matcher m = p.matcher(txt);
        while(m.find()) {
            amountValue = m.group(2);
        }
        BigDecimal amount = new BigDecimal(amountValue);
        return amount;
    }

    /**
     * uses tessaract to extract text from image
     * @param filePath
     * @return text from image
     */
    private String extractTextFromImage(String filePath) {
        File image = new File(filePath);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata");
        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        String result = null;
        try {
            result = tesseract.doOCR(image);
        } catch (Exception e) {
            System.out.println("Error with OCR" + e);
        }
        return result;
    }
}
