package com.niravra.finalproject.innerjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Driver {
	public static void main(String args[]) throws Exception {

		if (args.length != 3) {
			System.err.println("Usage: Inner Join <input_book> <input_rating> <input_user> <output>");
			System.exit(2);
		}
		Path geneInput = new Path(args[0]);
		Path mutatationInput = new Path(args[1]);
		Path intermediateOutput = new Path(args[2]);
		

		Configuration conf = new Configuration();

		Job job = Job.getInstance(conf, " leftouter Join ReduceSide");
		job.setJarByClass(Driver.class);

		MultipleInputs.addInputPath(job, geneInput, TextInputFormat.class, GeneMapper.class);
		MultipleInputs.addInputPath(job, mutatationInput, TextInputFormat.class, MutationMapper.class);
		job.getConfiguration().set("join.type", "leftouter");
		job.setReducerClass(InnerJoinReducer.class);

		job.setOutputFormatClass(TextOutputFormat.class);
		TextOutputFormat.setOutputPath(job, intermediateOutput);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		FileSystem hdfs = FileSystem.get(conf);
		if (hdfs.exists(intermediateOutput))
			hdfs.delete(intermediateOutput, true);

		boolean complete = job.waitForCompletion(true);


		

			System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}

}
