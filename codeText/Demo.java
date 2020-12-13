package com.guorenpcic.telesales.constant.telesales;


import java.util.*;

public class Demo {

    public static void main(String[] args) {

        Map map =new HashMap<>();
        map.put("0",Arrays.asList(""));
        map.put("1",Arrays.asList(""));
        map.put("2",Arrays.asList("A","B","C"));
        map.put("3",Arrays.asList("D","E","F"));
        map.put("4",Arrays.asList("G","H","I"));
        map.put("5",Arrays.asList("J","K","L"));
        map.put("6",Arrays.asList("M","N","O"));
        map.put("7",Arrays.asList("P","Q","R","S"));
        map.put("8",Arrays.asList("T","U","V"));
        map.put("9",Arrays.asList("W","X","Y","Z"));


        Scanner input = new Scanner(System.in);
        System.out.println("Please input num from 0 to 99:");
            //输入按键数字1-99
            String num="";
            while(true){
                num=input.next();
                if(!num.matches("[0-9]{1,2}")){
                    System.out.println("输入不合法！只能输入0-99的数字,请重新输入：");
                }else{
                    break;
                }
            }
            StringBuilder arrInput=new StringBuilder("Input:arr[] ={");
            String[] arrStr=num.split("");
            List<String[]> dataList=new ArrayList<String[]>();

            for(int i=0;i<arrStr.length;i++){
                arrInput.append(arrStr[i]);
                if(i<arrStr.length-1){
                    arrInput.append(",");
                }
                List<String> lettersList= (List<String>) map.get(arrStr[i]);
                if(lettersList.size()>0){
                    String[] letterArr= (String[]) lettersList.toArray();
                    dataList.add(letterArr);
                }
            }
            arrInput.append("}");
            List<String[]> resultList= maleCompose(dataList,0,null);
            System.out.println(arrInput.toString());
            System.out.print("Output:");
            for(int i=0;i<resultList.size();i++){
                String[] letterArr=resultList.get(i);
                System.out.print(" ");
                for(String s: letterArr){
                    System.out.print(s);
                }
            }
    }

    private static List<String[]> maleCompose(List<String[]> dataList, int index, List<String[]> resultList){
        if(index==dataList.size()){
            return resultList;
        }

        List<String[]> resultListOne=new ArrayList<String[]>();
        if(index==0){
            String[] dataArr=dataList.get(0);
            for(String s : dataArr){
                resultListOne.add(new String[]{s});
            }
        }else{
            String[] dataArr=dataList.get(index);
            for(String[] dataArr0: resultList){
                for(String s : dataArr){
                    String[] dataArrCopy=new String[dataArr0.length+1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length-1]=s;
                    resultListOne.add(dataArrCopy);
                }
            }
        }
        return maleCompose(dataList,++index,resultListOne);
    }


}
