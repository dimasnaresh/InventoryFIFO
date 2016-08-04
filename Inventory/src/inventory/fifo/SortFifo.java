/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.fifo;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author thread009
 */
public class SortFifo {
    
    public static void main(String[] xx){
        List<EntityTes> ent = new ArrayList<>();
        Fifo f = new Fifo();
        int year = 1995;
        int month = 12;
        int day  = 30;
        
        //set data for entity List
        for(int i = 0;i<9;i++){
            EntityTes data = new EntityTes();
            
            data.setName("Person "+i);
            data.setNumber(i);
            data.setBirthDate(new Date(year, month, day));
            day++;
            if(day > 31){
                day  = 1;
                month = 1;
                year++;
            }
            ent.add(data);
        }
        
        //start sorting fifo
        f.setArrayLengthIndex(ent.size(), 2);
        for(int i = 0;i<9;i++){
            f.add(ent.get(i).getName(), i);
            f.add(ent.get(i).getNumber(), i);
            f.setFieldDate(ent.get(i).getBirthDate(), i);
        }
        
        Object[][] testData = f.getFifoArray2Dimension();
        for(int i=0;i<f.getIndex();i++){
            for(int h=0;h<f.getLength();h++){
                System.out.print(testData[i][h]+", ");
            }System.out.println("");
        }
        
    }
    
}
