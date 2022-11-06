package me.futility.mactweaks
import net.fabricmc.api.ClientModInitializer

@Suppress("UNUSED")
object MacTweaks: ClientModInitializer {
    private const val MOD_ID = "mactweaks"
    override fun onInitializeClient() {
        println("MacTweaks is up!")
    }
}