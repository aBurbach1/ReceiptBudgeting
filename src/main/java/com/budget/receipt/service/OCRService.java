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

    public Expense runOCR(String filePath) {
        String textFromImage = extractTextFromImage(filePath);
//        System.out.println(textFromImage);
        Expense expense = parseExpense(textFromImage);
        System.out.println("Expense Cost: "  + expense.getCost());
        System.out.println("Expense Category: " + expense.getCategory());
        return expense;
    }

    private Expense parseExpense(String txt) {
        Expense expense = new Expense();
        String splicedTxt[] = txt.split(" ");
        expense.setCategory(getCategoryFromReceipt(txt));
        expense.setCost(getCostFromReceipt(txt));
        expense.setBudgetName("August 2021 Budget");
        return expense;
    }

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

    private boolean contains(String[] arr, String retailer) {
        for (String x : arr) {
            if(x.equals(retailer)) return true;
        }
        return false;
    }

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
