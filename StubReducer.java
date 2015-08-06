package my;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.util.Iterator;

public class StubReducer extends Reducer<Text, Text, Text, LongWritable> {

	@Override
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {

		//A4-P1-4
		Iterator<Text> v = values.iterator();

		String votee;
		String votesString = v.next().toString();

		if( votesString.matches("[0-9]+") ){
			Long votes = Long.valueOf( votesString );

			//Check if numeric if not abort.

			while( v.hasNext() ){
				votee = v.next().toString();
				//System.out.println("REDUCE: " + votee + " " + votes);
				context.write(new Text(votee), new LongWritable(votes));
			}
		}
	}
}
