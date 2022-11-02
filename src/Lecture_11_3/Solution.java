package Lecture_11_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
            String path = bR.readLine();
            BufferedReader bFR = new BufferedReader(new FileReader(path));
            List<Product> listProduct = new ArrayList<>();

            while (bFR.ready()) {
                String product = bFR.readLine();
                int id = Integer.parseInt(product.substring(0, 8).replace(" ", ""));
                String productName = product.substring(8, 38);
                double price = Double.parseDouble(product.substring(38, 46).replace(" ", ""));
                int quantity = Integer.parseInt(product.substring(46).replace(" ", ""));

                listProduct.add(new Product(id, productName, price, quantity));
            }

            if (args[0].equals("-u")) {
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getId() == Integer.parseInt(args[1])) {
                        listProduct.get(i).setProductName(args[2]);
                        listProduct.get(i).setPrice(Double.parseDouble(args[3]));
                        listProduct.get(i).setQuantity(Integer.parseInt(args[4]));
                    }
                }
            } else if (args[0].equals("-d")) {
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getId() == Integer.parseInt(args[1])) {
                        listProduct.remove(i);
                        i--;
                    }
                }
            }

            FileWriter fW1 = new FileWriter(path, false);
            fW1.write("");
            fW1.close();

            FileWriter fW2 = new FileWriter(path, true);

            for (int i = 0; i < listProduct.size(); i++) {
                fW2.write(String.format("%-8d%-30s%-8s%-4s",
                        listProduct.get(i).getId(),
                        listProduct.get(i).getProductName(),
                        listProduct.get(i).getPrice(),
                        listProduct.get(i).getQuantity()) + "\n");
            }

            fW2.flush();
            fW2.close();
            bR.close();
            bFR.close();
        }
    }

    static class Product {
        private int id;
        private String productName;
        private double price;
        private int quantity;

        public Product(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}

