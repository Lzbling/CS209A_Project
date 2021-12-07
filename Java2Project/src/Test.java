import java.util.ArrayList;

public class Test {
    // 本Test仅用于测试，开发完成后删除
    public static void main(String[] args) {
        DataProcess dp = new DataProcess();
        dp.readData("owid-covid-data.csv", ",");
        ArrayList<DataInfo> data = dp.getData();
        int row_id = 3;
        DataInfo data_row = data.get(row_id);
        System.out.println(data_row.getIso_code());
        System.out.println(data_row.getContinent());
        System.out.println(data_row.getLocation());
        System.out.println(data_row.getDate());
        System.out.println(data_row.getTotal_cases());
        System.out.println(data_row.getNew_cases());
        System.out.println(data_row.getStringency_index());
    }
}
