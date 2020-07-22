package k0722;

public class Client {
public static void main(String[] args) {
Seihin[] seihins = new Seihin[3];
seihins[0] = new Television();
seihins[1] = new Radio();
seihins[2] = new Television();
for (int i = 0; i < seihins.length; ++i) {
if (seihins[i] instanceof Television) {
((Television)seihins[i]).numberring();
((Television)seihins[i]).setDate(Date.today());
}
else if (seihins[i] instanceof Radio) {
((Radio)seihins[i]).numberring();
}
}
for (int i = 0; i < seihins.length; ++i) {
seihins[i].print();
}
}
}
abstract class Seihin {
public abstract void print();
}
class Television extends Seihin {
private int tvSerialNumber;
private String date;
public void numberring() {
tvSerialNumber = Counter.getTvNumber();
}
public void setDate(String date) {
this.date = date;
}
public void print() {
System.out.println("このテレビに関する情報:");
System.out.println(" 製造番号:" + tvSerialNumber);
System.out.println(" 製造年月日:" + date);
}
}
class Radio extends Seihin {
private int radioSerialNumber;
public void numberring() {
radioSerialNumber = Counter.getRadioNumber();
}
public void print() {
System.out.println("このラジオに関する情報:");
System.out.println(" 製造番号:" + radioSerialNumber);
}
}
class Date {
public static String today() {
return "2020/01/20";
}
}
class Counter {
private static int tvNum = 100;
private static int radioNum = 76;

public static int getTvNumber() {
return tvNum++;
}
public static int getRadioNumber() {
return radioNum++;
}
}