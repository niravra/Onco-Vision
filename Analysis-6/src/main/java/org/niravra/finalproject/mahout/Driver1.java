package org.niravra.finalproject.mahout;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import it.unimi.dsi.fastutil.ints.IntIterator;

public class Driver1 {
public static void main(String[] args)  {
		
		try {
			
//			File file = new File("/Users/niravrakar/Desktop/CosmicRecommend.txt");
//			FileDataModel transformer = new FileDataModel(file);
////			((Object) transformer).transformInPlace(file);
//			DataModel dm = new FileDataModel(file);
			DataModel dm = new FileDataModel(new File("/Users/niravrakar/Desktop/CosmicData433.txt"));
			
			UserSimilarity us = new PearsonCorrelationSimilarity(dm);
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, us, dm);
			
			GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(dm, neighborhood, us);
		

//				
//				Long itemId = items.nextLong();
				long[]recommendations = recommender.mostSimilarUserIDs(20, 3);
				
				for(long recommendation : recommendations) {
					

					
					System.out.println("The Value is : " +recommendation);
				
				}
//				numberOfOutput--;
//				if(numberOfOutput <=0) {
//					System.exit(1);
//				}
			
				
//			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
