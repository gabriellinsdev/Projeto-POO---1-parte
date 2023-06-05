import java.util.Date;

public class Chamada {
	 private Date data;
	 private Integer duracao;
	 
	 public Chamada(Date data, Integer duracao) {
		 this.data = data;
		 this.duracao = duracao;
	 }
	 
	 public Date getData() {
		 return data;
	 }
	 
	 public Integer getDuracao() {
		 return duracao;
	 }
	 
	 @Override
	 public String toString() {
		 return "Chamada [data=" + data + ", duracao=" + duracao + "]";
	 }
	 
}
