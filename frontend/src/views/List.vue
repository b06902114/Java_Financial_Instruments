<template>
    <main>
        <!--Navbar /-->
        <nav class = "navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class ="navbar-brand" herf="/">Financial Instrument</a>
                <button class="navbar-toggler" type = "button" data-bs-toggle="collapse" data-bs-target="#navbarSupportContent" aria-controls="navbarSupportContent" aria-expanded="false" aria-label="Toggle navigation ">
                    <span class="navbar-toggle-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <!--Menu-->
                        <li class="nav-item">
                            <a href="javascript:void(0);" @click="$event => GoTo_Menu()" class="nav-link">Menu</a> 
                        </li>
                         <!--List-->
                         <li class="nav-item">
                            <a href="javascript:void(0);" @click="$event => GoTo_List()" class="nav-link">Favorite List</a> 
                        </li>
                        <!--Log out-->
                        <li class="nav-item">
                            <a href="/" class="nav-link">Log Out</a>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>
        <!--table-->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">Your Favorite List</h1>
                    <table class="table talbe=striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Account</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--tr v-for="user in users" :key="user.id"-->
                                <th scope="row">{{ user.id }}</th>
                                <td>{{ user.name }}</td>
                                <td>{{ user.email }}</td>
                                <td>{{ user.account }}</td>
                                <td>
                                    <div class="col-md-12 form-group">
                                        <button class="btn btn-primary w-50" @click="$event => UpdateUser()">編輯</button>
                                    </div>
                                </td>
                            <!--/tr-->
                        </tbody>
                    </table>
                    <br>
                    <!--For Admin To Add Product-->
                    <!--a href='/add_product' class="btn btn-primary">Add Product</a-->
                    <table class="table talbe=striped">
                        <thead>
                            <tr>
                                <th scope="col">SN</th>
                                <th scope="col">User ID</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total FEE</th>
                                <th scope="col">Total Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="item in favoriteList" :key="item.num">
                                <th scope="row">{{ item.sn }}</th>
                                <td>{{ item.id }}</td>
                                <td>{{ item.quantity }}</td>
                                <td>{{ ftotal }}</td>
                                <td>{{ amount }}</td>
                                <!--For Update/Delete Product , Need Admin and Admin page-->
                                <td>
                                    <div class="col-md-12 form-group">
                                        <button class="btn btn-primary w-20" @click="$event => updateList(item.num, item.sn, item.id)">修改此項目</button>    
                                        <button class="btn btn-danger mx2" @click="$event => deleteList(item.num)">刪除此項目</button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </main>
</template>


<script>

//import Navbar from '../components/Navbar.vue';

export default {
    name: 'FavoriteList',
    components : {
        //Navbar
    },
    data(){
        return{
            userproduct:[],
            products: [],
            AllList:[],
            favoriteList: [],
            user: {
                    id: this.$route.params.id,
                    name: '',
                    email: '',
                    account: ''
            },
            p: {
                no:'',
                product_Name:'',
                price:0,
                fee_Rate:0.0
            },
            L: {
                num:0,
                sn: '',
                id:'',
                quantity:0
            },
            amount:0,
            ftotal:0.1,
        }
    },
    methods: {
        getList(){
            fetch(`http://localhost:9000/lists`)
            .then(response => { return response.json();})
            .then(responseData => {
            //console.log(responseData);
                    this.AllList = responseData;
                    //console.log(this.AllList)
                    var str = this.user.id
                    str = str.toUpperCase()
                    
                    this.favoriteList = this.AllList.filter(function(value){
                        var id = value.id
                        id = id.toUpperCase()
                        return id === str
                    })
                    //console.log(this.favoriteList)
                    this.amount = 0
                    this.ftotal = 0.1
                    this.favoriteList.forEach(item => {
                        var sn = item.sn
                        //console.log(sn)
                        fetch(`http://localhost:9000/product/${sn}`)
                        .then(response => { return response.json();})
                        .then(responseData => {
                            //console.log(responseData)
                            this.p = responseData
                            var pay = this.p.price * item.quantity;
                            var fee = pay * (this.p.fee_Rate);
                            this.amount += (pay + fee);
                            this.ftotal = (this.ftotal + fee);
                        
                            this.amount = parseInt(this.amount)
                            this.ftotal = parseInt(this.ftotal)          
                            //this.userproduct.push(this.p)
                        })
                       
                            
                    })
            })
            
            //console.log(this.userproduct)
             //this.amount = 0
            //total_fee = 0
        

        },
        getUser(){ 
            fetch(`http://localhost:9000/user/${this.$route.params.id}`)
            .then(response => { return response.json();})
            .then(responseData => {
            //console.log(responseData);
                    this.user = responseData;
            })
            .catch(err => console.log("err"))
                
        },
        getProducts(){
            fetch('http://localhost:9000/products')
            .then(res => res.json())
            .then(data => {
                this.products = data
                //console.log(data)
            })
        },
        updateList(num, sn, id) {
            this.L.num = num
            this.L.sn = sn
            this.L.id = id
            this.$router.push(`/editList/${this.L.num}/${this.L.sn}/${this.L.id}`)
        },
        deleteProduct(no){
            fetch(`http://localhost:9000/product/${no}`, {
                method: 'DELETE'
            })
            .then(data => {
                //console.log(data)
                this.getProduct()
            })
        },
        UpdateUser() {
            this.$router.push(`/edit/${this.user.id}/${this.user.email}/${this.user.account}`)
        },

        GoTo_Menu() {
            this.$router.push(`/home/menu/${this.user.id}`)
        },

        GoTo_List() {
            this.$router.push(`/home/list/${this.user.id}`)
        },
        deleteList(num) {
            fetch(`http://localhost:9000/list/${num}`, {
                method: 'DELETE'
            })
            .then(data => {
                console.log(data)
                this.getList()
            })
        
        },
    },
    beforeMount(){
        this.getProducts()
        this.getUser()
        this.getList()
        //this.calculate()
    }
}

</script>