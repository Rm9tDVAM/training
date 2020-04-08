import tkinter as tk
def click_btn():
    amount=int(amount_entry.get())
    people=int(people_entry.get())
    dnum=amount/people
    pay=dnum//100*100
    if dnum>pay:
      pay=int(pay+100)
    payorg=amount-pay*(people-1)
    show_label['text']='1人あたり{}円({}人)、幹事は{}円です'.format(pay,people-1,payorg)
root=tk.Tk()
root.title('割り勘くん')
root.resizable(False,False)
canvas=tk.Canvas(root,width=400,height=600,bg='skyblue')
canvas.pack()
button=tk.Button(text='計算する',font=('Times New Roman',18),command=click_btn)
button.place(x=10,y=180)
amount_entry=tk.Entry(width=20)
amount_entry.place(x=10,y=50)
people_entry=tk.Entry(width=20)
people_entry.place(x=10,y=120)
amount_label=tk.Label(root,text='金額',font=('Times New Roman',16),bg='skyblue')
amount_label.place(x=12,y=20)
people_label=tk.Label(root,text='人数',font=('Times New Roman',16),bg='skyblue')
people_label.place(x=12,y=90)
show_label=tk.Label(root,text='',font=('Times New Roman',20),bg='skyblue')
show_label.place(x=10,y=230)
root.mainloop()
