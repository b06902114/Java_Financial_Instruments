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
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width: 100%;">
                <h2 class="text-center mb-3">Add Product</h2>
                <form @submit.prevent="addProduct">
                     <!--No-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="No" class="form-label">No</label>
                            <input type="text" name="no" id="no" class="form-control" placeholder="No" required v-model="product.no">
                        </div>
                    </div>
                    <!--product_name-->
                    <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="Product_Name" class="form-label">Product Name</label>
                            <input type="text" name="product_name" id="product_name" class="form-control" placeholder="Product_Name" required v-model="product.product_Name">
                        </div>
                    </div>
                     <!--price-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="Price" class="form-label">Price</label>
                            <input type="text" name="price" id="price" class="form-control" placeholder="Price" required v-model="product.price">
                        </div>
                    </div>
                     <!--fee rate-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="Fee_Rate" class="form-label">Fee Rate</label>
                            <input type="text" name="fee_rate" id="fee_rate" class="form-control" placeholder="Fee_Rate" required v-model="product.fee_Rate">
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 form-group">
                            <input type="submit" value="Submit" class="btn btn-primary w-100">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

<script>
//import Navbar from '../components/Navbar.vue';

export default {
    name: 'AddProduct',
    components: {
       // Navbar
    },

    data() {
        return {
            product: {
                no: '',
                product_Name: '',
                price: '',
                fee_Rate: ''
            }
        }
    },

    methods: {
        addProduct(){
            //console.log(`qqqq ${this.product.no} ${this.product.product_name}`)
            fetch('http://localhost:9000/add_product', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.product)
            })
            .then(data => {
                console.log(data)
                alert('Add Successfully')
                this.$router.push("/home/menu/ADMIN")
            })
        },
        GoTo_Menu() {
            this.$router.push(`/home/menu/ADMIN`)
        },

        GoTo_List() {
            alert("ADMIN Do not go there")
            //this.$router.push(`/home/menu/${this.user.id}`)
        }
    }
}

</script>