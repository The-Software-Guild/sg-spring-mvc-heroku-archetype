/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ${package}.dao;

import ${package}.model.Record;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ahill
 */
public class RecordDaoMySQLImpl implements RecordDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public static String SQL_SELECT_ALL_RECORDS = "SELECT * FROM Records AS r "
            + " ORDER BY r.id";

    @Override
    public List<Record> getAllRecords() {
        return jdbcTemplate.query(SQL_SELECT_ALL_RECORDS, new RecordMapper());
    }

    public static String SQL_SELECT_ALL_RECORD_BY_ID = "SELECT * FROM Records AS r "
            + "WHERE r.id = ?";

    @Override
    public Record getRecord(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ALL_RECORD_BY_ID, new RecordMapper(), id);
        } catch (Exception e) {
            this.logException("Tried to find a record w/ this id " + id, e);
            return null;
        }
    }


    private static final String SQL_INSERT_NEW_RECORD = "INSERT INTO Records "
            + " (info) VALUES (?)";

    @Override
    public void addRecord(Record record) {
        jdbcTemplate.update(SQL_INSERT_NEW_RECORD,
                record.getInfo());
    }

    private static final String SQL_UPDATE_RECORD_NO_GENES = "UPDATE Records "
            + " SET indo = ? "
            + " WHERE id = ?";

    @Override
    public void updateRecord(Record record) {
        jdbcTemplate.update(SQL_UPDATE_RECORD_NO_GENES,
                record.getInfo(),
                record.getId());
    }

    public static String SQL_DELETE_RECORD = "DELETE FROM Records WHERE id = ?";

    @Override
    public void deleteRecord(int id) {
        jdbcTemplate.update(SQL_DELETE_RECORD, id);
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

//  CREATE TABLE Records(
//	`id` INT(11) NOT NULL AUTO_INCREMENT,
//      `info` VARCHAR(250) NOT NULL,
//    PRIMARY KEY (`id`)
//  );

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
