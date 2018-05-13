package model.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GNormal extends Graph{
	
	
	String texto;  
	int contador = 0;
	//local onde esta o texto
    private String arquivo = "C:\\Users\\lilia\\Desktop\\grafos.txt";  
    File file = new File(arquivo);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GNormal ler = new GNormal();
		ler.lerArquivo();
		//ler.getEdgeNumber(arquivo);
	}

      //le um grafo de um arquivo de texto
	//nao esta recebendo nada
    public void lerArquivo(){  
        try{  
            BufferedReader br = new BufferedReader(new FileReader(file));  
            while((texto = br.readLine()) != null){
            	
            	if(contador == 0) {
            	System.out.println("Número de vértices: " + texto);
            	contador += 1;
            	}else {
            	
            		System.out.println("Aresta: " + texto);
            		
            	}
            }  
        }catch(FileNotFoundException e){  
            e.printStackTrace();  
        }catch(IOException e){  
            e.printStackTrace();  
        }  
    }  
    
    //calcular o numero de arestas de um grafo
    //recebe um grafo
    public int getEdgeNumber(String arquivo) {
    	
    	System.out.println(arquivo + "tt");
    	
    	
    	return 1;
    	
    }
	
}
