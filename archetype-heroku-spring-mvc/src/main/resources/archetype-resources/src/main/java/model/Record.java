/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ${package}.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ahill
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Record {
    private int id;
    private String info;
}
