package model;



public class ModelMapPersonne {

	private String name;
	private String firstName;
	private String rq_sql;
	
	
	
	public String m_selectSpecifique  (String identifiant, String mdp) {
		
		
		return "call Identification(?,?)";
		
		
	}
	
	


	public String m_select  () {
		
		
		return "SELECT * FROM `tb_personne`";
		
		
	}
	
	

	
	public String m_insert  () {
		
		return "INSERT INTO `tb_personne` (`name`, `firstName`) VALUES ('" + this.name + "','" + this.firstName + "');" ;
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getRq_sql() {
		return rq_sql;
	}
	public void setRq_sql(String rq_sql) {
		this.rq_sql = rq_sql;
	}

	

}
