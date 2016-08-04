package inventory.fifo;

import java.util.Date;

/**
 *
 * @author thread009
 */
public class Fifo {
    
    private int length;
    private int index;
    private Object[][] data;
    
    /*
    * this method use for set index and length for array
    * this method must declare before add object
    * 
    */
    public void setArrayLengthIndex(int index, int length){
        this.length = length+1;
        this.index  = index;
        data = new Object[index][length+1];
    }

    /*
    * Get array 2 dimension length 
    */
    public int getLength() {
        return length;
    }

    /*
    * Get array 2 dimension index (data index)
    */
    public int getIndex() {
        return index;
    }
    
    /*
    * after setArrayLengthIndex(int index, int length) and setFieldDate(Object date, int index)
    * this method for add and prepare data for sorting
    * 
    */
    public void add(Object data, int index){
        
        for(int i=0; i < this.index; i++){
            
            if(index == i){
                
                for(int y = 0; y < this.length-1; y++){
                    if(this.data[i][y] == null){
                        this.data[i][y] = data;
                        break;
                    }else continue;
                }break;
            }
        }
    }
    
    /*
    * set date of data...
    */
    public void setFieldDate(Object date, int index){
        this.data[index][length-1] = date;
    }
    
    /*
    * get single array
    */
    public Object[] getArrayData(int index){
        Object getArr[] = new Object[this.length];
        for(int i=0; i < this.index; i++){
            
            if(index == i){
                
                for(int y = 0; y < this.length; y++)
                    getArr[y] = this.data[i][y];    
                break;
            }
        }
        
        return getArr;
    }
    
    /*
    * this method for sorting with fifo method
    * this method is use for inventory  system,
    * sorting data by date
    */
    public Object[][] getFifoArray2Dimension(){
        Object getFifo[][] = this.data;
        
        for (int x = 0; x < this.index-1; x++) {
            
            for (int i = 0; i < this.index-1; i++) {
                Object[][] newData = new Object[this.index][this.length];
                Date getDate1      =  (Date)getFifo[i][this.length-1];
                Date getDate2      =  (Date)getFifo[i + 1][this.length-1];
                
                if (getDate1.compareTo(getDate2) > 0) {
                    
                    
                    for(int j=0;j<this.length;j++)
                        newData[i][j] = getFifo[i][j];
                    for(int j=0;j<this.length;j++)
                        getFifo[i][j] = getFifo[i + 1][j];
                    for(int j=0;j<this.length;j++)
                        getFifo[i + 1][j] = newData[i][j];        
                }
            }
        }
        return getFifo;
    }
    
}
