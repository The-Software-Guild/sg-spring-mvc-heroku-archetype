/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ${package}.dao;

import ${package}.model.Record;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ahill
 */
public class RecordDaoMemImpl implements RecordDao {

    private Map<Integer, Record> records = new TreeMap<>();
    public RecordDaoMemImpl(){
        this.addRecord(new Record(0, "01101100 01101100 01100001 01101101 01100001"));
        this.addRecord(new Record(0, "01101100 01101100 01100001 01101101 01100001"));
        this.addRecord(new Record(0, "01100100 01110101 01100011 01101011 00100001"));
    }

    @Override
    public List<Record> getAllRecords() {
        return new ArrayList<>(records.values());
    }

    @Override
    public Record getRecord(int id) {
        return records.get(id);
    }

    @Override
    public void addRecord(Record record) {
       Optional<Integer> num = records.keySet().stream().max(Comparator.naturalOrder());
       if(num.isPresent()){
           record.setId(num.get() + 1);
       }else{
           record.setId(1);
       }
       
       this.records.put(record.getId(), record);
    }

    @Override
    public void updateRecord(Record record) {
        this.records.replace(record.getId(), record);
    }

    @Override
    public void deleteRecord(int id) {
        this.records.remove(id);
    }

    /*
    *  __   __  _______  _______  _______  _______  ______    _______ 
    * |  |_|  ||   _   ||       ||       ||       ||    _ |  |       |
    * |       ||  |_|  ||    _  ||    _  ||    ___||   | ||  |  _____|
    * |       ||       ||   |_| ||   |_| ||   |___ |   |_||_ | |_____ 
    * |       ||       ||    ___||    ___||    ___||    __  ||_____  |
    * | ||_|| ||   _   ||   |    |   |    |   |___ |   |  | | _____| |
    * |_|   |_||__| |__||___|    |___|    |_______||___|  |_||_______|
     */
    private static final class RecordMapper implements RowMapper<Record> {
//        CREATE TABLE public.record
//        (
//            id bigint NOT NULL,
//            info text COLLATE pg_catalog."default" NOT NULL,
//            CONSTRAINT record_pkey PRIMARY KEY (id)

        @Override
        public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
            Record mappedRecord = new Record();
            mappedRecord.setId(rs.getInt("id"));
            mappedRecord.setInfo(rs.getString("info"));

            return mappedRecord;
        }
    }

    /*
    *  __   __  _______  ___      _______  _______  ______   
    * |  | |  ||       ||   |    |       ||       ||    _ |  
    * |  |_|  ||    ___||   |    |    _  ||    ___||   | ||  
    * |       ||   |___ |   |    |   |_| ||   |___ |   |_||_ 
    * |       ||    ___||   |___ |    ___||    ___||    __  |
    * |   _   ||   |___ |       ||   |    |   |___ |   |  | |
    * |__| |__||_______||_______||___|    |_______||___|  |_|
     */
    private void logException(String header, Exception e) {
        System.out.println(" ====================== BGN DAO EXCEPTION LOG ====================== ");
        System.out.println(header);
        System.out.println(" -------- Message -------- ");
        System.out.println(e.getMessage());
        System.out.println(" -------- Stack Trace -------- ");
        e.printStackTrace(System.out);
        System.out.println(" ====================== END DAO EXCEPTION LOG ====================== ");

    }
}
