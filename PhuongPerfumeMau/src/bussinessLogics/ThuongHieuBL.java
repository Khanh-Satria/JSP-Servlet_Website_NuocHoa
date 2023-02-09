package bussinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import javaBeans.ThuongHieu;

public class ThuongHieuBL {

		public static List<ThuongHieu> docTatCa(){
			
			List<ThuongHieu> dsth = new ArrayList<ThuongHieu>();
			try(Connection kn = CSDL.getKN()){
				String sql="select * from thuonghieu";
				Statement stm = kn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					ThuongHieu th = new ThuongHieu();
					th.setId(rs.getInt("id"));
					th.setTenThuongHieu(rs.getString("tenthuonghieu"));
					th.setHinhAnh(rs.getString("hinhanh"));
					
					dsth.add(th);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsth;
		}
		
		public static ThuongHieu docTheoID(int id) {
			ThuongHieu th = null;
			try(Connection kn = CSDL.getKN()){
				String sql="select * from thuonghieu where id='"+id+"'";
				Statement stm = kn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					th = new ThuongHieu();
					th.setId(rs.getInt("id"));
					th.setTenThuongHieu(rs.getString("tenthuonghieu"));
					th.setHinhAnh(rs.getString("hinhanh"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return th;
		}
}


