package org.niravra.finalproject.mahout;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.longs.LongIterator;

public class Driver {
	
	public static void main(String[] args)  {
		
		try {
			DataModel dm = new FileDataModel(new File("/Users/niravrakar/Desktop/CosmicDataInteger.csv"));
			ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
		//	UserSimilarity us = new PearsonCorrelationSimilarity(dm);
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
		//	NearestNUserNeighborhood nb = new NearestNUserNeighborhood(25,us,dm);
		//	TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(dm);
			int numberOfOutput =10;
			for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();) {
				
				Long itemId = items.nextLong();
				List<RecommendedItem>recommendations = recommender.mostSimilarItems(itemId, 5);
				
				for(RecommendedItem recommendation : recommendations) {
					
					System.out.println(itemId + "," + recommendation.getItemID() + 
							"," + recommendation.getValue());	
				
				}
				numberOfOutput--;
				if(numberOfOutput <=0) {
					System.exit(1);
				}
				
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
