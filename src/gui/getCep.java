package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class getCep {
	
	public String results;
	
	public boolean result(String cep) {
		
		String webservice = "https://viacep.com.br/ws/" + cep + "/json";
		String method = "GET";
		
		try {

            // conexao
            URL url = new URL(webservice);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200)
                throw new RuntimeException("HTTP ERROR CODE " + conn.getResponseCode());

            // Input
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String output;
            
            while((output = br.readLine()) != null){
                result.append(output);
            }
            
            JSONObject response = new JSONObject(result.toString());
            
            this.results = String.format(
            		"Logradouro: %s \n"
            		+ "Bairro: %s \n"
            		+ "Localidade: %s-%s \n"
            		+ "DDD: %s"
            		, response.get("logradouro"), response.get("bairro"), response.get("localidade"), response.get("uf"), response.get("ddd"));
            
           return true;
		
		}catch(Exception err) {
			err.printStackTrace();
			return false;
		}
		
		
		
	}

}
