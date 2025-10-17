# 🎓 Ethical Admissions Algorithm Simulation

This repository is a classroom exercise exploring **ethics and fairness in algorithmic decision-making** — specifically in college admissions.

You’ll implement and reflect on how feature selection and weighting can impact fairness, transparency, and equity in automated systems.

---

## 🧩 Overview

You are part of the admissions committee for **Anonymous University**, located near Anonymous City.  
Due to a large number of applications, the committee decides to use an algorithm to help **rank and shortlist applicants**.

Your task:
- Decide which factors to include (GPA, test scores, extracurriculars, essays, recommendation letters, legacy status, income, etc.)
- Assign weights to each factor.
- Compare outcomes under two models:
  - **Blind model**: Ignores sensitive factors.
  - **Aware model**: Includes them intentionally to promote fairness (e.g., extra weight for first-gen or low-income applicants).

---

## ⚙️ How to Run

You can run the code on any online Java compiler (e.g. [Replit](https://replit.com/~) or [Programiz Java Compiler](https://www.programiz.com/java-programming/online-compiler))  
or locally via terminal:

```bash
javac Applicant.java Admissions.java Main.java
java Main
