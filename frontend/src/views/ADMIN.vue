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
                            <a href="javascript:void(0);" @click="$event => GoTo_addproduct()" class="nav-link">Add Product</a> 
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
                    <h1 class="text-center">Financial Instrument Menu</h1>
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
                            <!--/tr-->
                        </tbody>
                    </table>
                    <br>
                    <!--For Admin To Add Product-->
                    <!--a href='/add_product' class="btn btn-primary">Add Product</a-->
                    <table class="table talbe=striped">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">FEE Rate</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="product in products" :key="product.no">
                                <th scope="row">{{ product.no }}</th>
                                <td>{{ product.product_Name }}</td>
                                <td>{{ product.price }} 新臺幣 </td>
                                <td>{{ product.fee_Rate }}  ({{(product.fee_Rate * 100)}}%)</td>
                                <!--For Update/Delete Product , Need Admin and Admin page-->
                                <td>
                                    <div class="col-md-12 form-group">
                                        <button class="btn btn-danger mx2" @click="$event => Delete(product.no)">Delete</button>
                                        <button class="btn btn-primary mx2" @click="$event => ADD()">ADD</button>
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



export default {
    name: 'Menu',
    components : {
        
    },
    data(){
        return{
            products: [],
            user: {
                    id: '',
                    name: '',
                    email: '',
                    account: ''
            }
        }
    },
    methods: {
        getUser(){ 
                var uid = "ADMIN"
                fetch(`http://localhost:9000/user/${uid}`)
                .then(response => { return response.json();})
                .then(responseData => {
                    this.user = responseData;
                })
                .catch(err => console.log("err"))
                
        },
        ADD() {
            this.$router.push(`/add_product`)
        },  
        getProducts(){
            fetch('http://localhost:9000/products')
            .then(res => res.json())
            .then(data => {
                this.products = data
            })
        },
        Delete(no){
            fetch(`http://localhost:9000/product/${no}`, {
                method: 'DELETE'
            })
            .then(data => {
                this.getProducts()
            })
        },
        UpdateUser() {
            this.$router.push(`/edit/${this.user.id}/${this.user.email}/${this.user.account}`)
        },

        GoTo_Menu() {

        },

        GoTo_addproduct() {
        },
        // no = sn
    },
    beforeMount(){
        this.getProducts()
        this.getUser()
    }
}

</script>