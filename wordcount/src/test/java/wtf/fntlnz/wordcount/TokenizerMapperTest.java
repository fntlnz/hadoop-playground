package wtf.fntlnz.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenizerMapperTest {
    @Test
    public void testMap() throws IOException {
        TokenizerMapper mapper = new TokenizerMapper();
        MapDriver<Object, Text, Text, IntWritable> mapDriver;
        mapDriver = MapDriver.newMapDriver(mapper);

        mapDriver.withInput(new Object(), new Text("Testing map map"));
        mapDriver.withOutput(new Text("Testing"), new IntWritable(1));
        mapDriver.withOutput(new Text("map"), new IntWritable(1));
        mapDriver.withOutput(new Text("map"), new IntWritable(1));

        mapDriver.runTest();
    }
}
