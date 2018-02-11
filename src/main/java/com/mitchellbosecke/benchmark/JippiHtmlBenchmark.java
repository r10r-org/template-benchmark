package com.mitchellbosecke.benchmark;

import com.mitchellbosecke.benchmark.model.Stock;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.r10r.jippihtml.JippiHtml;
import static org.r10r.jippihtml.JippiHtml.*;



public class JippiHtmlBenchmark extends BaseBenchmark {

    private List<Stock> stocks;

    @Setup
    public void setup() throws IOException {
        // no config needed, replicate stocks from context
        this.stocks = Stock.dummyItems();
    }

    @Benchmark
    public String benchmark() throws TemplateException, IOException {
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringBuilder s = new StringBuilder(10000);
        TemplateBenchmark.template(this.stocks).renderToWriter(s);
        return s.toString();
    }

}