package formation.dao;

public class DaoSalleFactory {
	public static DaoSalle getDaoSalle() {
		return new DaoSalleImpl();
	}
}
