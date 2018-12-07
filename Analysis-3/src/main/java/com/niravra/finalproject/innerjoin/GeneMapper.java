package com.niravra.finalproject.innerjoin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class GeneMapper extends Mapper<Object, Text, Text, Text> {

    private Text outkey = new Text();
    private Text outvalue = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        
        {
            if (value.toString().length()>0 && !value.toString().startsWith("Gene"))
            {
                try {
                    String values[] = value.toString().split("	");
                    outkey.set(values[0]);
                    outvalue.set("G1" + value);
                    context.write(outkey, outvalue);
                    
                    
                    
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(GeneMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
