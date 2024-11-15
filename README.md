# Membuat Frame Login Dengan GUI menggunakan Persistance

---
## 🗂️ Table Of Contents
- [Frame Login](https://github.com/adeliafhr/Tugas-Pertemuan-Tigabelas/blob/main/PertemuanDuaBelas/src/pertemuanduabelas/Login.java)
- [Frame Buat Akun](https://github.com/adeliafhr/Tugas-Pertemuan-Tigabelas/blob/main/PertemuanDuaBelas/src/pertemuanduabelas/Buat.java)
- [Persistance](https://github.com/adeliafhr/Tugas-Pertemuan-Tigabelas/blob/main/PertemuanDuaBelas/src/pertemuanduabelas/Akun.java)

---
## 📋 Langkah - Langkah Penggunaan
## 1.	Membuat tabel pada database
### a) Membuat tabel dengan nama akun 
![image](https://github.com/user-attachments/assets/6b5d313e-2dee-4ec6-ac29-2c67631327bc)

---
### b) Isi data pada tabel 
![image](https://github.com/user-attachments/assets/a2fe8b78-2e0c-4044-825c-2d760c1a472c)

---
## 2.	Membuat persistence 
### a) Membuat persistence unit dengan cara klik kanan project lalu pilih `Entity class from Database`
![image](https://github.com/user-attachments/assets/63df652b-4492-4bd8-9b91-c0f9c1a954df)

---
### b) Masukkan password postgreSql
![image](https://github.com/user-attachments/assets/672f1b05-db2e-440c-a137-7d1c05bd6bc0)

---
### c) Pilih koneksi database dan pindahkan tabel akun pada kotak sebelah kanan
![image](https://github.com/user-attachments/assets/47786f82-a87d-445f-89f4-c92aa6304e98)

---
### d) Jika entity class sudah benar maka klik next
![image](https://github.com/user-attachments/assets/a643de77-393f-4562-a0ff-db5e6db36081)

---
### e) Lalu pilih finish
![image](https://github.com/user-attachments/assets/25b58a3f-3bad-4a1b-b82b-079c505fd254)

---
### 3.	Setelah membuat persistence, maka akan muncul package META-INF dan file Akun.java
![image](https://github.com/user-attachments/assets/3d1c2796-8ed3-4263-8617-ba69c0fe7920)

---
### 4.	Membuat desain GUI untuk frame login
![image](https://github.com/user-attachments/assets/6be6973d-c949-46e4-8994-80dbbc949cee)

---
### 5. Berikut adalah source code dari button login
<pre>
  private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (tfUser.getText().equals("") | tfPw.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi Terlebih Dahulu");
        } else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanDuaBelasPU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            String user = tfUser.getText();
            String pw = tfPw.getText();
            Akun y = em.find(Akun.class, user);

            if (y == null) {
                JOptionPane.showMessageDialog(null, "Username tidak ditemukan");
            } else if (y.getPassword().equals(pw)) {
                JOptionPane.showMessageDialog(null, "SELAMAT DATANG!!!");
                Mata_Kuliah p = new Mata_Kuliah();
                p.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah!");
            }
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }
</pre>

---
### 6.	Membuat desain GUI untuk frame buat akun yang berfungsi untuk menambah akun  
![image](https://github.com/user-attachments/assets/b5b1eb65-de29-418f-959e-c1d3f273cdfc)

---
### 7.	Berikut adalah source code dari button create / buat
<pre>
  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if (tfUser.getText().equals("") || tfPw.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data terlebih dahulu!");
        } else {
            String user, pw;
            user = tfUser.getText();
            pw = tfPw.getText();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanDuaBelasPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Akun y = em.find(Akun.class, user);
            if (y != null) {
                JOptionPane.showMessageDialog(null, "Username sudah ada, coba gunakan username lain");
                bersih();
            } else {
                Akun x = new Akun();
                x.setUsername(user);
                x.setPassword(pw);
                em.persist(x);

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Sukses dibuat");

                bersih();
                Login z = new Login();
                z.setVisible(true);
                this.dispose();
            }
            em.close();
            emf.close();
        }
    }
</pre>

---
## 8.	Simulasi dari beberapa frame yang telah dibuat
### a) Masukkan username dan password yang telah dibuat pada tabel akun di database sebelumnya
![image](https://github.com/user-attachments/assets/008639c0-aacf-4690-b8af-a24a999cd0f7)

---
### b) Ketika belum mempunyai akun, maka klik buat akun dan akan muncul tampilan seperti ini 
![image](https://github.com/user-attachments/assets/ad7d2b92-4cb4-4e31-b024-d5dc7c4baea1)

---
### c) Coba masukkan username yang telah dibuat di frame buat akun pada frame login
![image](https://github.com/user-attachments/assets/23909173-aaae-438c-90be-3046f34a1a25)

---
### d) Setelah berhasil, maka akan muncul frame mata kuliah untuk melakukan CRUD. Ketika memilih button logout maka akan kembali ke frame login
![image](https://github.com/user-attachments/assets/eeb5eae7-d8bc-497f-b31d-abbb7e6ab5a1)

---
## 🌟Selamat bereksplorasi lebih luas mengenai Persistance pada Java 🚀 ##


