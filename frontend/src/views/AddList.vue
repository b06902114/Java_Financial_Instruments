<template>
    <main>
        <!--Navbar/-->
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
            <div class="mx-auto w-25" style="max-width: 100;">
                <h2 class="text-center mb-3">Enter Quantity</h2>
                <form @submit.prevent="addList">
                    <!--ID-->
                   <!--div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="ID" class="form-label">ID</label>
                            <input type="text" name="ID" id="ID" class="form-control" placeholder="ID" required v-model="user.id">
                        </div>
                    </div-->
                   <!--name-->
                   <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="quantity" class="form-label">Quantity</label>
                            <input type="text" name="Quantity" id="quantity" class="form-control" placeholder="Quantity" required v-model="L.quantity">
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
    import axios from 'axios';

    export default {
        name: 'UpdateUser',
        components: {
            //Navbar
        },
        data(){
            return {
                user: {
                    id: this.$route.params.id,
                    name: this.$route.params.name,
                    email: this.$route.params.email,
                    account: this.$route.params.account
                },
                L: {
                    sn: this.$route.params.no,//
                    id: this.$route.params.id,//
                    quantity:0
                }

            }
        },

        methods: {
            addList() {
                fetch('http://localhost:9000/add_list', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.L)
                })
                .then(data => {
                    //console.log(data)
                    //alert(data.message)
                    this.$router.push(`/home/menu/${this.L.id}`)
                })
            },
       
            GoTo_List() {
                this.$router.push(`/home/list/${this.L.id}`)
            },

            GoTo_Menu() {
                this.$router.push(`/home/menu/${this.L.id}`)
            }

        },

        beforeMount(){
           
        }
    }

   

   


</script>