package info.kuronekoya.sjistools;

import java.io.UnsupportedEncodingException;

/**
 * SJISTools実行用クラス
 */
public class SJISToolsTester {

  public static void main(String[] args) throws UnsupportedEncodingException {
    // ShiftJISをエンコードした文字列をデコードした文字列を取得する
    System.out.println(SJISTools.getDecodedString("%95%bd%94%aa%96%40%88%ea%81%5a%8b%e3"));
  }
}
