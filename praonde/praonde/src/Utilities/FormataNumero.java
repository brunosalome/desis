package Utilities;

public class FormataNumero {
	public String formatar(String s){
		System.out.println("Original:"+s);
		int i = s.indexOf(",");
	    int inteiro = Integer.parseInt(s.substring(0, i));
	    System.out.println("Inteiro: "+inteiro);
		String decimalS = s.substring(i+1, s.length());
		System.out.println("Decimal: "+decimalS);
		if(decimalS.length()==2){
			s = inteiro + "," + decimalS;
		}else if(decimalS.length()>2){
			if(decimalS.charAt(decimalS.length()-1)=='0')
				s = inteiro + "," + decimalS.substring(0, 2);
			else
				s = inteiro + "," + decimalS.substring(0, 3);
		}else{
			s = inteiro+",00";
		}
        return s;
}

}
