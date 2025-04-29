package com.arcade.dao;

import com.arcade.config.HibernateConfig;
import com.arcade.modelo.entidad.Resultado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ResultadoDAOImpl implements ResultadoDAO {

    @Override
    public void guardar(Resultado resultado) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(resultado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Resultado obtenerPorId(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Resultado.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resultado> obtenerTodos() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Resultado", Resultado.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resultado> obtenerPorTipoJuego(String tipoJuego) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Resultado> query = session.createQuery("FROM Resultado WHERE tipoJuego = :tipo", Resultado.class);
            query.setParameter("tipo", tipoJuego);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}