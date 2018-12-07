package com.niravra.finalproject.innerjoin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MutationMapper extends Mapper<Object, Text, Text, Text> {

    private Text outkey = new Text();
    private Text outvalue = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        
        Text primarySite = new Text();
	    Text genomePosition = new Text();
		
       
        {
            if (value.toString().length()>0 && !value.toString().startsWith("Gene"))
            {
                try {
                    String values[] = value.toString().split("	");
                    primarySite.set(values[0]);
//                    genomePosition.set(values[23]);
                    genomePosition.set("M1" + values[23]);
                    	context.write(primarySite, genomePosition);
                    
                    
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(MutationMapper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
