//package test;
//
//public class CompanyTest11 {
//
//    public static int count(String needle, InputStream haystack) throws Exception {
//
//        StringBuffer sb = new StringBuffer();
//        byte[] b = new byte[4096];
//        for (int n; (n = haystack.read(b)) != -1;) {
//            sb.append(new String(b, 0, n));
//        }
//        String str = sb.toString();
//
//        String[] arr = str.split("\n");
//        int count = 0;
//
//        for(String s : arr) {
//            if(s.contains(needle) == true)
//                count += 1;
//        }
//
//        return count;
//    }
//    public static void main(String[] args){
//
//        int answer = new CompanyTest11().count(caseA);
//
//        System.out.println(answer);
//    }
//}
