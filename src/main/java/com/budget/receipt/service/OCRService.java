package com.budget.receipt.service;

import com.budget.receipt.model.expense.Expense;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OCRService {

    private Map<String, String[]> categoryToRetailerMap = new HashMap<String, String[]>();
    public OCRService() {
        categoryToRetailerMap.put("Grocery", new String[]{"Walmart", "Bakers"});
        categoryToRetailerMap.put("Rent", new String[]{});
        categoryToRetailerMap.put("Mortgage", new String[]{});
        categoryToRetailerMap.put("Entertainment", new String[]{});
        categoryToRetailerMap.put("Transportation", new String[]{});
        categoryToRetailerMap.put("Laundry", new String[]{});
        categoryToRetailerMap.put("Utilities", new String[]{});
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
        String retailer = splicedTxt[0];
        expense.setCategory(getCategoryFromRetailer(retailer));
//        expense.setCost(getCostFromReceipt(splicedTxt));
        expense.setCost(new BigDecimal("30"));
        expense.setBudgetName("August 2021 Budget");
        expense.setDate(new Date());
        return expense;
    }

    private BigDecimal getCostFromReceipt(String[] splicedTxt) {
        String amountValue = "0";
        //TODO fix this with regex!
//        int foundTotalIndex = 0;
//        for (int i = 0; i < splicedTxt.length; i++) {
//            String word = splicedTxt[i].trim().toUpperCase();
//            System.out.println("arr[" + i+ "] is " + word);
//            if(word.equals("TOTAL")) {
//                foundTotalIndex = i;
//                break;
//            }
//        }
//        if(foundTotalIndex > 0) amountValue = splicedTxt[foundTotalIndex + 1];
//        System.out.println("in getCostFromReceipt: found amount: " + amountValue);
        BigDecimal amount = new BigDecimal(amountValue);
        return amount;
    }

    private String getCategoryFromRetailer(String retailer) {
        String category = "";
        for(Map.Entry<String, String[]> e: this.categoryToRetailerMap.entrySet()) {
            if(contains(e.getValue(),retailer)) {
                category = e.getKey();
                break;
            }
        }
        return category;
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
