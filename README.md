Anggota Kelompok:
-Jason Hermawan
-Yoel Nathanael
-Matthew Vandersen
-Muhammad Fatra Mahdivikia Rusli

Step By Step:
1. Download JDK 21 x64 MSI Installer (jika windows) dan JavaFX 21.0.9 (kalau JDK 21 ga bisa berarti yang 25 aja)
2. Download dan buka Eclipse IDE
3. Install e(fx)clipse 3.8.0 di Eclipse Marketplace... (ada di "Help" diatas)
4. Klik "Window" diatas, lalu klik "Preferences", di kiri klik Java > Build Path > User Libraries
5. Tambah Library "New" lalu beri nama (nama lebih baik "JavaFX")
6. Add External JARs ke Library JavaFX tadi (buka folder JavaFX 21.0.9 yang di download, buka folder lib lalu select semuanya dan Open)
7. Apply and Close Preferences
8. Tambah project klik "File" diatas, kemudian New > Other... > JavaFX > JavaFX Project (nama project "LibraManaged")
9. Kosongkan src
10. Masukan semua package dan class ke src (nama setiap package dan class serta struktur/letak class harus sesuai dengan yang di GitHub)
11. Copy codingan dari setiap class di GitHub (pastikan paste ke sesuai class masing-masing)
12. Klik kanan "LibraManaged" lalu Build Path > Configure Build Path
13. Klik "Libraries" diatas lalu Add Library di Classpath, lalu User Library baru pilih JavaFX, Finish lalu Apply dan Apply and Close
14. Klik kanan "LibraManaged" lalu Run As > Run Configurations
15. Klik "Arguments" diatas, lalu bagian VM arguments tambah ini:
--module-path "path-ke-folder-lib-masing2" --add-modules javafx.controls,javafx.graphics,javafx.fxml
16. Setelah Apply, klik "Dependencies" diatas, Remove JavaFX di Classpath Entries
17. Di Modulepath Entries, Advanced > Add Library > User Library > JavaFX tambahkan
18. Finish kalau sudah, lalu Apply dan kemudian Run
19. Untuk CSV, bikin folder data di eclipse, lalu drag file semua CSV yang didapat dari GitHub ke folder data yang di eclipse


git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/yoelnathanael16/JavaOOP_Project.git
git push -u origin main


git remote add origin https://github.com/yoelnathanael16/JavaOOP_Project.git
git branch -M main
git push -u origin main
