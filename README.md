# splitwise
Requirement gathering
1. Group -> name, description, members, expenses, default currency, settle up feature(simplify option)
2. Every expenses that we will add will have the following info:-
   Description, Amount with its currency, Date, Who paid how much(paid), who owes how much(had to pay), createdAt, createdBy, updatedAt, updatedBy, What was updated
3. User:- name, phone, email, expenses (List <Expense> ), total outstanding across all groups
4. Everything we can consider as group expenses (group size >= 2)
5. Simplify group debts:-
6. Settle up
   After adding all the expenses in the group if we press settle up, then you have to show who pays to whom how much
7. How to settle up in splitwise
   We don't do any settle ups at an individual level, but we do it for everyone in the group
   After going through all the transactions, we can get two info
   (A,B,C,D) -> 10 Transactions

          PAID             HAS TO PAY
   -----|---------------|-------------
     A  |   6000        |   5000      +1000
     B  |   3000        |   5000      -2000
     C  |               |
     D  |               |

   We can figure out total outstanding amount for each person (credit or debit)
   Figure out the minimum number of transactions , once we have total outstanding for each person
