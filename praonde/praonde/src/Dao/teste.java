package Dao;

public class teste {
	
	int cont = 0;
	
	public void teste(int tent){
		if (tent>0){
			teste(tent-1);
			for (int i=1; i<=tent;i++){
				cont++;
			}
			teste(tent-1);
		}
	}
	
	public void imprime(){
		System.out.println(cont);
	}

}


