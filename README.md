# object-csv-java
<b>
A simple Library to convert CSV format to Java model.
</b>

<h2>How to use ?</h2>
<b> for sample example project visit <a href="@">here</a> </a>
<br/>

<div>
  <span>Primary helper class : </span>
  <b>ObjectCsv</b>
    <br/>
  <code>
  import com.sahurjt.objectcsv.ObjectCsv;
  </code>
  <br/>
  <b>Methods</b>
    <br/>
  <ul>
    <li>
      <b>getInstance : </b> first method to call, to create instance of ObjectCsv.
      <br/>     
    </li>
    <li>
            <b>with(CsvDelimiter delimiterType): </b> uses delimiterType to parse CSV.
      <br/>
      CsvDelimiter is enum having value COMMA,SPACE,COLLON,PIPE,TAB.
    </li>
    <li>     <b>from(List<String> lines): </b> uses given lines as CSV data.
   </li>
    <li><b>from(String filePath): </b> reads CSV file from filePath.</li>
    <li>      <b>getCsvHolderforClass(Class<T> classInstance) </b>
      Parses raw CSV data to java model
      <br/>classInstance:java class to be mapped with CSV data.</li>
    <li> <b>Exception : ObjectCsvException </b></li>
  </ul>
</div>
