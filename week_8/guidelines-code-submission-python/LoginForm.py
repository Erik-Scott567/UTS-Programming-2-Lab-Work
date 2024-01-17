import tkinter as tk

class LoginFormApplication(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("LoginForm")
        self.label1 = tk.Label(self, text = "Username:")
        self.tf1 = tk.Entry(self)
        self.label2 = tk.Label(self, text = "Password:")
        self.tf2 = tk.Entry(self)
        self.result = tk.Label(self, text = "")

        self.Btn = tk.Button(text = "Login", command= lambda:self.compare())

        self.label1.grid(row = 0, column=0, sticky=tk.W)
        self.tf1.grid(row = 0, column=1, sticky=tk.W)
        self.label2.grid(row = 1, column=0, sticky=tk.W)
        self.tf2.grid(row = 1, column=1, sticky=tk.W)
        self.Btn.grid(row = 2, column=1, sticky=tk.W)
        self.result.grid(row = 3, column=1, sticky=tk.W)

    def compare(self):
        username = str(self.tf1.get())
        password = str(self.tf2.get())
        current_username = str("sam")
        current_password = str("mypassword")
        if username == current_username and password == current_password:
            self.result.config(text="Password correct!")
        else:
            self.result.config(text="Password incorrect!")

if __name__ == '__main__':
    app = LoginFormApplication()
    app.mainloop()


