package wtf.fntlnz.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntSumReducerTest {
    @Test
    public void testReduce() throws IOException {
        IntSumReducer reducer = new IntSumReducer();
        ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
        List<IntWritable> exampleValues = new ArrayList<IntWritable>();
        exampleValues.add(new IntWritable(1));
        exampleValues.add(new IntWritable(1));
        reduceDriver.withInput(new Text("example"), exampleValues);
        reduceDriver.withOutput(new Text("example"), new IntWritable(2));
        reduceDriver.runTest();
    }
}
