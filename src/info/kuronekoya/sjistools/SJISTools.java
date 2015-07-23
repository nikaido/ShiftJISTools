package info.kuronekoya.sjistools;

import java.nio.charset.Charset;

public class SJISTools {

  /**
   * Shift-JISのエンコード文字列をデコードした文字列を取得する
   * @param input Shift-JISのエンコード文字列
   * @return デコードした文字列
   */
  public static String getDecodedString(String input){
    // charの配列にする
    char[] inputCharArr = input.toCharArray();

    // 新しい配列。長さは高々inputCharArrの長さ
    byte[] newCharArr = new byte[inputCharArr.length];
    
    int inputArrPointer = 0;
    int newArrPointer = 0;

    while(inputArrPointer<inputCharArr.length){
      char currentChar = inputCharArr[inputArrPointer];
      if(currentChar!='%'){
        // %以外の文字であればそのままnewCharArrに代入する
        newCharArr[newArrPointer] = (byte)currentChar;
        
        // それぞれのポインタを進める
        ++inputArrPointer;
        ++newArrPointer;
      } else {
        // それ以外の場合は、inputCharArrから2文字分読み込む
        char nextChar = inputCharArr[inputArrPointer+1];
        char afterNextChar = inputCharArr[inputArrPointer+2];
        String hexStr = "0x" + nextChar+afterNextChar;
        newCharArr[newArrPointer] = (byte)(Integer.decode(hexStr).intValue());
        
        inputArrPointer+=3;
        ++newArrPointer;
      }
    }
    
    // ShiftJISをutf8に変換して返す
    return new String(newCharArr, 0, newArrPointer, Charset.forName("Shift_JIS"));
  }
}
