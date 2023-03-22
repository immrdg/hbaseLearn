import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.List;

public class CreateTable {
    public static void main(String[] args) throws IOException {
        // Instantiating the Configuration class with HBase configuration
        Configuration conf = HBaseConfiguration.create();

        // Creating a Connection instance using the Configuration object
        Connection connection = ConnectionFactory.createConnection(conf);

        // Instantiating the Admin class to perform administrative operations
        Admin admin = connection.getAdmin();



        // I need to create employee table
        TableName employeeTable = TableName.valueOf("employee");
        System.out.println(employeeTable);

        // In my employee table im going to add two families -> personal and professional

        ColumnFamilyDescriptor personal = ColumnFamilyDescriptorBuilder.of("personal");
        ColumnFamilyDescriptor professional = ColumnFamilyDescriptorBuilder.of("professional");

        System.out.println(personal);
        System.out.println(professional);


        TableDescriptor tableDescriptor =
                TableDescriptorBuilder.newBuilder(employeeTable).
                        setColumnFamilies(List.of(personal,professional)).
                        build();

        System.out.println(tableDescriptor);

        admin.createTable(tableDescriptor);

        boolean isTableCreated = admin.tableExists(employeeTable);

        System.out.println("Is Table Created : "+(isTableCreated?"yes":"no"));


    }
}
