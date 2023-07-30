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
                <h2 class="text-center mb-3">Update User</h2>
                <form @submit.prevent="updateUser">
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
                            <label for="name" class="form-label">Name</label>
                            <input type="text" name="name" id="name" class="form-control" placeholder="Name" required v-model="user.name">
                        </div>
                    </div>
                     <!--email-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="email" class="form-label">Email;</label>
                            <input type="text" name="email" id="email" class="form-control" placeholder="Email" required v-model="user.email">
                        </div>
                    </div>
                     <!--account-->
                     <div class="row">
                        <div class="col-md-12 form-group mp-3">
                            <label for="account" class="form-label">Account</label>
                            <input type="text" name="account" id="account" class="form-control" placeholder="Account" required v-model="user.account">
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
                }
            }
        },

        methods: {
            
            getUser(){ 
                fetch(`http://localhost:9000/user/${this.$route.params.id}`)
                .then(response => { return response.json();})
                .then(responseData => {
                    //console.log(responseData);
                    this.user = responseData;
                })
                .catch(err => console.log("err"))
                
            },
            
            updateUser(){
                fetch(`http://localhost:9000/user_update`, {
                    method: 'PUT',
                    headers: {
                    'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.user)
                })
                .then(data => {
                    //console.log(data)
                    alert('Edit Successfully') 
                    this.$router.push(`/home/menu/${this.user.id}`)
                })
            },
            
            GoTo_List() {
            this.$router.push(`/home/list/${this.user.id}`)
            },
            GoTo_Menu() {
                this.$router.push(`/home/menu/${this.user.id}`)
            }

        },

        beforeMount(){
           this.getUser()
           //console.log(this.$route.params.name)
        }
    }

   

   


</script>