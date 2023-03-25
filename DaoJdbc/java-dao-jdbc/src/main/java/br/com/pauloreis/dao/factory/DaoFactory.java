package br.com.pauloreis.dao.factory;

import br.com.pauloreis.dao.DepartmentDao;
import br.com.pauloreis.dao.SellerDao;
import br.com.pauloreis.dao.jdbc.DepartmentDaoJDBC;
import br.com.pauloreis.dao.jdbc.SellerDaoJDBC;
import br.com.pauloreis.db.DB;

public class DaoFactory {

  public static SellerDao createSellerDao() {
    return new SellerDaoJDBC(DB.getConnection());
  }

  public static DepartmentDao createDepartmentDao() {
    return new DepartmentDaoJDBC(DB.getConnection());
  }
}
