package my;
import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class StubMapper extends Mapper<Object, Text, Text, Text> {

	@Override
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {

		//A4-P1-4

		String[] words = value.toString().split("[ \t]+");

		context.write(new Text(words[0]), new Text(words[1]));
		//System.out.println("MAP: " + words[0] + " " + words[1]);
	}
}
