package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {
	public QLSVModel model;
	public JPanel contentPane;
	public JTextField textField_MaSinhVien_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JLabel label_HoVaTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_QueQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox comboBox_QueQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 710);
		
		QLSVController listen = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(listen);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(listen);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(listen);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(listen);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(listen);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_QueQuan = new JLabel("Quê Quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan.setBounds(20, 10, 96, 57);
		contentPane.add(label_QueQuan);
		
		JLabel label_MaThiSinh = new JLabel("Mã Thí Sinh");
		label_MaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_MaThiSinh.setBounds(291, 10, 134, 57);
		contentPane.add(label_MaThiSinh);
		
		textField_MaSinhVien_TimKiem = new JTextField();
		textField_MaSinhVien_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaSinhVien_TimKiem.setColumns(10);
		textField_MaSinhVien_TimKiem.setBounds(409, 13, 143, 52);
		contentPane.add(textField_MaSinhVien_TimKiem);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(listen);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnTim.setBounds(591, 12, 89, 52);
		contentPane.add(btnTim);
		
		comboBox_QueQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_QueQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan_timKiem.addItem(tinh.getTenTinh());
		}
		
		comboBox_QueQuan_timKiem.setBounds(126, 10, 143, 52);
		contentPane.add(comboBox_QueQuan_timKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 81, 796, 2);
		contentPane.add(separator_1);
		
		JLabel label_danhSachThiSInh = new JLabel("Danh Sách Thí Sinh");
		label_danhSachThiSInh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_danhSachThiSInh.setBounds(10, 88, 229, 38);
		contentPane.add(label_danhSachThiSInh);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn ", "Qu\u00EA qu\u00E1n", "Ng\u00E0y Sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 126, 796, 192);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 328, 796, 2);
		contentPane.add(separator_1_1);
		
		JLabel label_QueQuan_1 = new JLabel("Thông tin thí sinh");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan_1.setBounds(10, 336, 159, 57);
		contentPane.add(label_QueQuan_1);
		
		JLabel label_ID = new JLabel("Mã thí sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID.setBounds(10, 375, 134, 57);
		contentPane.add(label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(126, 389, 166, 29);
		contentPane.add(textField_ID);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(126, 428, 166, 29);
		contentPane.add(textField_HoVaTen);
		
		label_HoVaTen = new JLabel("Họ và tên");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HoVaTen.setBounds(10, 414, 134, 57);
		contentPane.add(label_HoVaTen);
		
		JLabel label_QueQuan1 = new JLabel("Quê quán");
		label_QueQuan1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan1.setBounds(10, 451, 134, 57);
		contentPane.add(label_QueQuan1);
		
		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		
		comboBox_QueQuan.setBounds(126, 467, 166, 29);
		contentPane.add(comboBox_QueQuan);
		
		JLabel label_NgaySinh = new JLabel("Ngày sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_NgaySinh.setBounds(10, 496, 134, 57);
		contentPane.add(label_NgaySinh);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(126, 510, 166, 29);
		contentPane.add(textField_ngaySinh);
		
		JLabel label_gioiTinh = new JLabel("Giới tính");
		label_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_gioiTinh.setBounds(372, 375, 134, 57);
		contentPane.add(label_gioiTinh);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setBounds(485, 389, 59, 29);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setBounds(558, 389, 96, 29);
		contentPane.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();// Để chọn được 1 trong 2
		btn_gioiTinh.add(radioButton_nu);
		btn_gioiTinh.add(radioButton_nam);
		
		textField_mon1 = new JTextField();
		textField_mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(488, 428, 166, 29);
		contentPane.add(textField_mon1);
		
		JLabel label_Mon1 = new JLabel("Môn 1");
		label_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon1.setBounds(372, 414, 134, 57);
		contentPane.add(label_Mon1);
		
		textField_mon2 = new JTextField();
		textField_mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(488, 467, 166, 36);
		contentPane.add(textField_mon2);
		
		JLabel label_Mon2 = new JLabel("Môn 2");
		label_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon2.setBounds(372, 455, 134, 57);
		contentPane.add(label_Mon2);
		
		textField_mon3 = new JTextField();
		textField_mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(488, 510, 166, 29);
		contentPane.add(textField_mon3);
		
		JLabel label_Mon3 = new JLabel("Môn 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon3.setBounds(372, 496, 134, 57);
		contentPane.add(label_Mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(listen);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThem.setBounds(33, 578, 111, 52);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(listen);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(176, 578, 116, 52);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(listen);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCapNhat.setBounds(323, 578, 125, 52);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(listen);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLuu.setBounds(485, 578, 116, 52);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(listen);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuyBo.setBounds(622, 578, 116, 52);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 566, 796, 2);
		contentPane.add(separator_1_1_1);
		
		JButton btnHuyTim = new JButton("Hủy");
		btnHuyTim.addActionListener(listen);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuyTim.setBounds(690, 12, 89, 52);
		contentPane.add(btnHuyTim);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaSinhVien_TimKiem.setText("");
		textField_ngaySinh.setText("");
		textField_mon1.setText("");
		textField_mon2.setText("");
		textField_mon3.setText("");
		comboBox_QueQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.textField_ID.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_ngaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_mon1.setText(ts.getDiemMon1() + "");
		this.textField_mon2.setText(ts.getDiemMon2() + "");
		this.textField_mon3.setText(ts.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa chứ?");
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		// Get du lieu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_QueQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_ngaySinh.getText());
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_mon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		
		// Thuc hien tim kiem
		int queQuan = this.comboBox_QueQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaSinhVien_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinh = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinh.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maThiSinhTimKiem.length() > 0) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while ((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
}	
}
