package mavemJpa.controller;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mavemJpa.model.Produto;

public class DataBaseController {

	EntityManagerFactory emf;
	EntityManager em;

	public DataBaseController() {

		this.emf = Persistence.createEntityManagerFactory("mavemJpa");
		this.em = emf.createEntityManager();
	}

	public void saveData(Produto produto) {

		this.em.getTransaction().begin(); // inicia a transa��o como banco
		this.em.persist(produto);
		this.em.getTransaction().commit(); // m�todo persiste pega um objeto e salva no bando de dados
		System.out.println(produto + " SALVO com Sucesso no Banco de Dados!");

	}

	public Produto findProductById(int id) {

		return em.find(Produto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public  List<Produto> findProducts(String sentence) {
		
		List<Produto> produtos = null;
		
		try {
			Query query = em.createQuery("from Produto query where query.nome like ?0");
			query.setParameter(0, "%"+sentence+"%");
			produtos = query.getResultList();			
		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println(erro);
		}
		
		for(Produto nickname : produtos) {
			System.out.println(nickname);
		}
		
		return produtos; 		
		
		
	}
	
	

	public void deleteProduct(Produto produto) {

		// Quando n�o � um opera��o de consulta tem que colocar uma transa��o
		// Update, Delete, Create tem que colocar uma transa��o
		if (produto != null) {
			try {
				this.em.getTransaction().begin();
				this.em.remove(produto);
				this.em.getTransaction().commit();
				System.out.println(produto + " REMOVIDO com sucesso do Banco de Dados!");
			} catch (Exception erro) {
				erro.printStackTrace();
			}
		} else {
			System.out.println("ERRO ao tentar REMOVER produto " + produto);
		}

	}

	public void closeConnection() {

		this.em.close();
		this.emf.close();
		System.out.println("Encerrada conex�o com o Bando de Dados");

	}

}
