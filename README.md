# Πληροφοριακό Σύστημα Διαχείρισης Βιβλιοπωλείου 📚

Αυτό το πληροφοριακό σύστημα απευθύνεται σε επιχειρήσεις βιβλιοπωλείων και έχει στόχο την καθημερινή οργάνωση και διαχείριση του καταστήματος.  
Προσφέρει δυνατότητες όπως διαχείριση αποθέματος, αναζήτηση συγγραμμάτων, παρακολούθηση στατιστικών και καταγραφή ιστορικού αγορών.

## Ρόλοι Χρηστών & Δικαιώματα  
- **Πελάτης**:  
  - Αναζήτηση και προβολή συγγραμμάτων  
  - Έλεγχος διαθεσιμότητας και ημερομηνίας κυκλοφορίας  
  - Ιστορικό αγορών και αγαπημένα συγγράμματα  

- **Υπάλληλος**:  
  - Διαχείριση αποθέματος (διαθεσιμότητα & ποσότητες)  
  - Παρακολούθηση και ενημέρωση ιστορικού αγορών πελατών  

- **Ιδιοκτήτης**:  
  - Όλες οι λειτουργίες του υπαλλήλου  
  - Παρακολούθηση στατιστικών ζήτησης και αγορών για λήψη αποφάσεων  



## Λειτουργικές Απαιτήσεις  

### Απαραίτητα (Must Have)  
- Εγγραφή, Σύνδεση & Αποσύνδεση χρηστών  
- Διαχείριση αποθέματος από υπαλλήλους  
- Αναζήτηση συγγραμμάτων από πελάτες  
- Προβολή διαθεσιμότητας και ημερομηνίας κυκλοφορίας  
- Καταγραφή και ανάγνωση ιστορικού αγορών  

### Καλό να Υπάρχουν (Should Have)  
- Δυνατότητα αλλαγής κωδικού πρόσβασης  
- Προβολή αγαπημένων συγγραμμάτων  
- Παρακολούθηση στατιστικών από ιδιοκτήτη  

### Προαιρετικά (Could Have)  
- Σύστημα ειδοποιήσεων για χαμηλό απόθεμα  

### Δεν Θα Υλοποιηθούν Τώρα (Won’t Have)  
- Ενσωμάτωση ηλεκτρονικών πληρωμών  




## Τεχνολογίες  
- Java & Spring Boot  
- PostgreSQL  
- JWT Authentication  
- Lombok  

## Εκκίνηση  
1. Κλωνοποιήστε το αποθετήριο  
2. Ρυθμίστε και εκκινήστε τη βάση PostgreSQL  
3. Εκτελέστε την εφαρμογή (`mvn spring-boot:run` ή μέσω IDE)  
4. Χρησιμοποιήστε τα API endpoints για διαχείριση χρηστών και αποθέματος  

---
