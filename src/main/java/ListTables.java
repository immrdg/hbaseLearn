import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.List;

public class ListTables {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();

        Connection connection = ConnectionFactory.createConnection(conf);

        Admin admin=connection.getAdmin();

        List<TableDescriptor> tableDescriptor = admin.listTableDescriptors();
        tableDescriptor.forEach(table -> System.out.println(table.getTableName()) );

    }
}
