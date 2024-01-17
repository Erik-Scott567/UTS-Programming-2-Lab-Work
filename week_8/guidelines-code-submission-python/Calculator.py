import tkinter as tk

class CalculatorApplication(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Calculator")
        self.label1 = tk.Label(self, text = "First number:")
        self.tf1 = tk.Entry(self)
        self.label2 = tk.Label(self, text = "Second number:")
        self.tf2 = tk.Entry(self)

        self.Btn1 = tk.Button(text = "+", command= lambda:self.add())
        self.Btn2 = tk.Button(text = "-", command= lambda:self.minus())
        self.Btn3 = tk.Button(text = "*", command= lambda:self.mult())
        self.Btn4 = tk.Button(text = "/", command= lambda:self.div())

        self.result = tk.Label(self, text = "")

        self.label1.grid(row = 0, column=0, sticky=tk.W)
        self.tf1.grid(row = 0, column=1, sticky=tk.W)
        self.label2.grid(row = 1, column=0, sticky=tk.W)
        self.tf2.grid(row = 1, column=1, sticky=tk.W)
        self.Btn1.grid(row = 2, column=0, sticky=tk.W)
        self.Btn2.grid(row = 2, column=1, sticky=tk.W)
        self.Btn3.grid(row = 2, column=2, sticky=tk.W)
        self.Btn4.grid(row = 2, column=3, sticky=tk.W)
        self.result.grid(row = 3, column=1, sticky=tk.W)

    def add(self):
        num1 = int(self.tf1.get())
        num2 = int(self.tf2.get())
        result = num1 + num2
        self.result.config(text=result)

    def minus(self):
        num1 = int(self.tf1.get())
        num2 = int(self.tf2.get())
        result = num1 - num2
        self.result.config(text=result)

    def mult(self):
        num1 = int(self.tf1.get())
        num2 = int(self.tf2.get())
        result = num1 * num2
        self.result.config(text=result)

    def div(self):
        num1 = int(self.tf1.get())
        num2 = int(self.tf2.get())
        result = num1 / num2
        self.result.config(text=result)

if __name__ == '__main__':
    app = CalculatorApplication()
    app.mainloop()
