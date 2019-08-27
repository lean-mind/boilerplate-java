package es.leanmind.boilerplace.helpers

class OSUtils {
    companion object {
        var OS: String? = null

        fun isWindows(): Boolean {
            return if (getOSName() != null) getOSName()!!.contains("win") else false
        }

        fun isMac(): Boolean{
            return if (getOSName() != null) getOSName()!!.contains("mac") else false
        }

        fun isLinux(): Boolean {
            return if (getOSName() != null) getOSName()!!.contains(Regex("nix|nux|aix")) else false
        }

        private fun getOSName(): String? {
            if (OS == null)
                OS = System.getProperty("os.name").toLowerCase()

            return OS
        }
    }
}
